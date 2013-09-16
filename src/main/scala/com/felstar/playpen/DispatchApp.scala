package com.felstar.playpen

import dispatch._,Defaults._
import xml.PrettyPrinter
import scala.xml.XML

object DispatchApp {
    
  def main(args : Array[String]) {

   val svc = url("http://mymovieapi.com/?q=matrix&type=xml")
   val pp=new PrettyPrinter(80,2)

   // returns immediately, no waiting
   val movieinfo = Http(svc OK as.String)

    // here we wait for future. We could have done work previously
   val m = movieinfo()
   
   val xml=XML.loadString(m)
   println(pp.format(xml))       
   
   Http.shutdown
  }
}
