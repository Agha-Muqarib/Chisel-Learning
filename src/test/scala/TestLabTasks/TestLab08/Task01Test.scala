package Lab08

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Task01Test extends FreeSpec with ChiselScalatestTester {

    "Task 01 Test" in {

        test(new MemoryBank) { c =>

            // For requester 0

            c.io.Writeaddr.poke(0.U)
            c.io.Readaddr.poke(0.U)
            c.io.write.poke(true.B)

            c.io.requestor(0).bits.poke(5.U)

            c.io.requestor(0).valid.poke(true.B)
            c.io.requestor(1).valid.poke(false.B)
            c.io.requestor(2).valid.poke(false.B)
            c.io.requestor(3).valid.poke(false.B)
            c.clock.step(1)

            // For requester 1

            c.io.Writeaddr.poke(0.U)
            c.io.Readaddr.poke(0.U)
            c.io.write.poke(true.B)

            c.io.requestor(1).bits.poke(2.U)

            c.io.requestor(1).valid.poke(true.B)
            c.io.requestor(0).valid.poke(false.B)
            c.io.requestor(2).valid.poke(false.B)
            c.io.requestor(3).valid.poke(false.B)
            c.clock.step(1)

            // For requester 2

            c.io.Writeaddr.poke(0.U)
            c.io.Readaddr.poke(0.U)
            c.io.write.poke(true.B)

            c.io.requestor(2).bits.poke(3.U)

            c.io.requestor(2).valid.poke(true.B)
            c.io.requestor(3).valid.poke(false.B)
            c.io.requestor(1).valid.poke(false.B)
            c.io.requestor(0).valid.poke(false.B)
            c.clock.step(1)

            // For requester 3

            c.io.Writeaddr.poke(0.U)
            c.io.Readaddr.poke(0.U)
            c.io.write.poke(true.B)

            c.io.requestor(3).bits.poke(4.U)
            
            c.io.requestor(3).valid.poke(true.B)
            c.io.requestor(0).valid.poke(false.B)
            c.io.requestor(2).valid.poke(false.B)
            c.io.requestor(1).valid.poke(false.B)

            c.clock.step(3)            
            
        }
    }
}