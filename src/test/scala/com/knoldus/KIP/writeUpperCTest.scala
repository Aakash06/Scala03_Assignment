package com.knoldus.KIP

import org.scalatest.FunSuite

class writeUpperCTest extends FunSuite {

  val obj = new FolderIO

  val fun= new writeUpperC(obj)

  val booleanList:List[Boolean] = fun.function("src/test/inputfolder/","src/test/outputfolder/",".txt")

  test("Read Files from directory and write in directory"){
    assert(booleanList==List(true, true))
  }

}

