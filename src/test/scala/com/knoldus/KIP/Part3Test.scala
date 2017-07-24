package com.knoldus.KIP

import org.scalatest.FunSuite

class Part3Test extends FunSuite {


  val obj= new FolderIO

  val fun = new Part3(obj)

  val booleanList:Boolean = fun.readWriteFile("src/test/inputfolder/part3",".txt")

  test("Read Files from directory and write in directory"){
    assert(booleanList.==(true))
  }

}
