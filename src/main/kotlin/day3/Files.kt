package day3

import java.io.File


data class Path(val path: String) {
    fun toFile(): File = File(path)
}


data class FileError(val fileName: Path, val exception: Throwable?) : Error {
    override val msg: String
        get() = "Error on file $fileName: ${exception?.message}"
}


class FileWriter(val fileName: Path) : Writer<String> {
    operator fun invoke(writeLine: () -> String?): Outcome<FileError, Unit> =
        Outcome.tryThis {
            runWriter(writeLine)
        }.mapFailure {
            FileError(fileName, it.t)
        }

    override fun runWriter(f: () -> String?): Unit = TODO("it needs to call f() until the result is a null")
}


class FileReader(val fileName: Path) : Reader<Path, List<String>> {
    operator fun <T> invoke(lineReader: (String) -> T): Outcome<FileError, List<T>> =

        Outcome.tryThis {
            runReader(fileName).map(lineReader)
        }.mapFailure {
            FileError(fileName, it.t)
        }


    override fun runReader(context: Path): List<String> = TODO()

    override fun local(f: (Path) -> Path): FileReader = TODO()

}
