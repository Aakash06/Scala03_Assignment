package com.knoldus.KIP

import java.io.{File, PrintWriter}

import scala.io.Source

class FolderIO extends ReaderWriter {

  override def read(inputUrl: String,extension:String): List[(String, String)] = {
    val FileObject = new File(inputUrl)
    val listOfFiles = FileObject.listFiles(_.getName.endsWith(extension)).toList
    listOfFiles.map(x => (x.getName, Source.fromFile(x.getAbsolutePath.toString).getLines().mkString))
  }

  override def write(outputUrl: String, nameOfFile: String, textInFile: String): Boolean = {

      val writer = new PrintWriter(new File(outputUrl + File.separator + nameOfFile))
      writer.write(textInFile)
      writer.close()
      true
    }
}
