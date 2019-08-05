package day3

import java.nio.file.Path


data class FileError(val fileName: Path, val exception: Throwable?) : Error {
    override val msg: String
        get() = "Error on file $fileName: ${exception?.message}"
}


class FileWriter(val fileName: Path) {
    operator fun invoke(writeLine: () -> String?): Outcome<FileError, Unit> {

        runCatching {
            fileName.toFile().writer().use {

                while (true) {
                    val line = writeLine() ?: return@use
                    it.append("$line\n")
                }
            }
        }.onFailure {
            return FileError(fileName, it).asFailure()
        }

        return Unit.asSuccess()

    }
}

class FileReader(val fileName: Path) {
    operator fun invoke(readLine: (String) -> Unit) {

    }
}
