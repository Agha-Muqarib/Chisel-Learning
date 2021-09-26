package Lab06

import chisel3._
import chisel3.util._

class Exercise04 extends Module {
    
    val io = IO(new Bundle {
    val in = Flipped(Decoupled(UInt(8.W))) // valid = Input , ready =Output , bits = Input
    val out = Decoupled(UInt(8.W))
    
    })

    io.out.bits := 0.U
    io.out.valid := true.B

    val queue01 = Queue(io.in, 5)
    val queue02 = Queue(queue01,5) 

    queue01.nodeq()
    queue02.nodeq()

     when (queue02.valid && io.out.ready) {

        io.out.enq(queue02.deq())

    }
}