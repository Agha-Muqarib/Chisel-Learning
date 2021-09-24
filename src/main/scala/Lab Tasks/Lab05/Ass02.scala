package Lab05

import chisel3._
import chisel3.util._

class dataPackets [ T <: Data ] ( gen: T ) extends Bundle{

   val address = gen
   val data = UInt(10.W)
   
}

class Router [ T <: Data ]( gen: T ) extends Module {

    val io = IO(new Bundle{

        val in = Input(new dataPackets(gen))
        val out = Output(new dataPackets(gen))
    })

    // val addressout = io.in.address
    // val dataout = io.in.data

    // io.out.address := addressout
    // io.out.data := dataout

    io.out <> io.in
}