package com.knoldus.KIP

abstract class ReaderWriter {

  def read(inputUrl:String,extension:String): List[(String,String)]

  def write(outputUrl:String,nameOfFile:String,textInFile:String): Boolean

}
