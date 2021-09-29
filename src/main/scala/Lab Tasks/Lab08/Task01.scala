package Lab08
import chisel3._
import chisel3.util._


class BankIO extends Bundle {

    val memory_out = Vec(4, Output(UInt(32.W)))
    val requestor = Vec(4, Flipped(Decoupled (UInt(32.W))))
    val Readaddr = Input(UInt(5.W))
    val Writeaddr = Input(UInt(5.W))
    val write = Input(Bool())
    val out = Decoupled(UInt(4.W))

}

class MemoryBank extends Module {

    val io = IO (new BankIO)
    val queue1 = Queue(io.requestor(0),1)
    val queue2 = Queue(io.requestor(1),1)
    val queue3 = Queue(io.requestor(2),1)
    val queue4 = Queue(io.requestor(3),1)

    val arb_priority = Module (new Arbiter(UInt(),4))
     
    arb_priority.io.in(1) <> queue2
    arb_priority.io.in(0) <> queue1
    arb_priority.io.in(2) <> queue3
    arb_priority.io.in(3) <> queue4
    io.out <> arb_priority.io.out

    val memory1 = Mem(1024, UInt(32.W))
    val memory2 = Mem(1024, UInt(32.W))
    val memory3 = Mem(1024, UInt(32.W))
    val memory4 = Mem(1024, UInt(32.W))

    when (io.write) {

        memory1.write(io.Writeaddr, arb_priority.io.out.bits(0))
        memory2.write(io.Writeaddr, arb_priority.io.out.bits(1))
        memory3.write(io.Writeaddr, arb_priority.io.out.bits(2))
        memory4.write(io.Writeaddr, arb_priority.io.out.bits(3))

    }

    io.memory_out(0) := memory1.read(io.Readaddr)
    io.memory_out(1) := memory2.read(io.Readaddr)
    io.memory_out(2) := memory3.read(io.Readaddr)
    io.memory_out(3) := memory4.read(io.Readaddr)
    
}