package com.knoldus.KIP

import org.scalatest.FunSuite

class secondPartTest extends FunSuite {


  val obj= new FolderIO

  val fun = new secondPart(obj)

  val booleanList:List[Boolean] = fun.function("src/test/inputfolder/","src/test/outputfolder/part2",".txt")

  test("Read Files from directory and write in directory"){
    assert(booleanList==List(true, true))
  }

}
