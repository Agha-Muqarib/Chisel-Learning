package Lab01

import chisel3._
import chisel3.util._
import java.io.File

class Task04(n: Int) extends Module {
val io = IO(new Bundle {
    val data_in = Input(UInt(n.W))
    val reload = Input(Bool())
    val out = Output(Bool())
})

var counter = RegInit(0.U(n.W))
val max_count = RegInit(6.U(n.W))

val flag = RegInit (false.B)

when ( flag === false.B ) {

    counter := counter + 1.U
    }


    .otherwise{
        counter := counter-1.U
    }

when (counter=== max_count){
    flag := true.B
}

.elsewhen (counter===0.U){
    flag := false.B
}

io.out := counter(7.U)
} 

