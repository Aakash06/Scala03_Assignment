package com.knoldus.KIP

import java.io.File

class writeUpperC(folderIO : FolderIO) {

  def function(inputUrl:String,outputUrl:String,extension:String):List[Boolean]={
    val listOfFilesWithData = folderIO.read(inputUrl,extension)
    //create new Directory
    new File(outputUrl).mkdir()
    //write the data in different directory with same name
  val ab = for { file <-listOfFilesWithData
        ab1 = folderIO.write(outputUrl,file._1,file._2.toString.toUpperCase)
  }yield ab1
    ab
  }
}
