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

    override fun runWriter(f: () -> String?) = TODO()
}



class FileReader(val fileName: Path) {

    operator fun <T> invoke(lineReader: (String) -> T): Outcome<FileError, List<T>> = TODO()
}
