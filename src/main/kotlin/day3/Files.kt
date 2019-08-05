package day3

import java.nio.file.Path


data class FileError(val fileName: Path, val exception: Throwable?) : Error {
    override val msg: String
        get() = "Error on file $fileName: ${exception?.message}"
}


class FileWriter(val fileName: Path): Writer<String> {
    operator fun invoke(writeLine: () -> String?): Outcome<FileError, Unit> {

        runCatching {
            runWriter(writeLine)
        }.onFailure {
            return FileError(fileName, it).asFailure()
        }

        return Unit.asSuccess()

    }

    override fun runWriter(f: () -> String?) {
        fileName.toFile().writer().use {

            while (true) {
                val line = f() ?: return@use
                it.append("$line\n")
            }
        }
    }
}



class FileReader(val fileName: Path) {

    operator fun <T> invoke(lineReader: (String) -> T): Outcome<FileError, List<T>> {

        return runCatching {
            runReader(lineReader)
        }.fold(
            {it.asSuccess()},
            {FileError(fileName, it).asFailure()})

    }

    fun <U> runReader(lineReader: (String) -> U): List<U> {
        val collector = mutableListOf<U>()
        fileName.toFile().reader().forEachLine {
            collector.add(lineReader(it))
        }
        return collector
    }
}
