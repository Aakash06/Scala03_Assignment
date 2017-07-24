package com.knoldus.KIP

import org.scalatest.FunSuite

class FolderIOTest extends FunSuite {

  val obj = new FolderIO

  val readData= obj.read("src/test/inputfolder/","txt")
  test("Read Data from file"){
    assert(readData==List(("input.txt","Hello My name is Aakash Aakash"), ("input2.txt","Hello Knoldus")))
  }

  val writeData = obj.write("src/test/outputfolder/","input.txt","helloo")
  test("Write Data In file"){
    assert(writeData==true)
  }
}
