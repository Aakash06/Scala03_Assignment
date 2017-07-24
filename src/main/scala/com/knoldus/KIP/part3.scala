package com.knoldus.KIP

import java.io.FileNotFoundException

object parsingURL{
  def unapply(url: String): Option[(String, String, String, Map[String, String])] = {

    val protocolPart = url.split("://")

    if(protocolPart.length == 1) {
      None
    }
    else {
      val protocol = protocolPart(0)
      val hostDomainPart = protocolPart(1).split("/")

      val hostDomain = hostDomainPart(0).split('.')
      val host = hostDomain(1)

      val domain = if (hostDomain.length > 3) {
        hostDomain(2) + "." + hostDomain(3)
      }
      else {
        hostDomain(2)
      }

      //if(hostDomainPart.length > 1) {
      val queryPart = hostDomainPart(1).split("\\?")(1)
      val queryArray = queryPart.split("&")

      val arr = for {a <- queryArray
                     a1 = a.split("=")(0)
                     a2 = a.split("=")(1)
      } yield (a1, a2)

      val query = arr.toList.toMap

      /*else {
        None
      }*/
      Some(protocol,host,domain,query)
    }
  }

}

class Part3(folderIO: FolderIO){

  def parseUrl(url : String): String = {

    url match{
      case parsingURL(protocol, host, domain, query) => "Protocol -> " + protocol + "\nHost -> " +
        host + "\nDomain -> " + domain + "\nQuery Parameter -> " + query + "\n"
      case _ => "Cannot be Parsed"
    }
  }

  def readWriteFile(inputURL:String,extension:String): Boolean ={

      val listOfFilesWithData = folderIO.read(inputURL,extension)

      val file = listOfFilesWithData.head

      if (listOfFilesWithData.isEmpty) {
        throw new FileNotFoundException("File is not readable")
      }
      else {
        val fileContentArray: Array[String] = file._2.split("\n")
        val fileOutput: Array[String] = for {line <- fileContentArray
                                             output = parseUrl(line)
        } yield output

        folderIO.write(inputURL,"Output" + file._1,fileOutput.mkString)
      }
    }
}
