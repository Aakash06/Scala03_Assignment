package com.knoldus.KIP

import java.io.File

class secondPart(folderIO : FolderIO) {

  def function(inputUrl:String,outputUrl:String,extension:String):List[Boolean]={
    val listOfFilesWithData = folderIO.read(inputUrl,extension)
    //create new Directory
    new File(outputUrl).mkdir()
    //write the data in different directory with same name

    val ab = for { file <-listOfFilesWithData
                   allConvertedText=file._2.toLowerCase.replaceAll("[^a-zA-Z0-9]"," ").split("\\s+").groupBy(x=>x).mapValues(x=>x.length).mkString("\n")
                   ab1 = folderIO.write(outputUrl,file._1,allConvertedText)
    }yield ab1
    ab
    }
  }

