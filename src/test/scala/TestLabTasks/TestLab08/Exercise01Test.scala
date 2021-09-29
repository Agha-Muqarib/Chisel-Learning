package Lab08

import chisel3._
import org.scalatest._
import chiseltest._


class Exercise01Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 01 Test" in {

        test(new NoOverload) { c => 
            
            c.io.enable.poke(true.B)
            c.io.write.poke(true.B)
            c.io.addr.poke(3.U)

            c.io.memMask(0).poke(true.B)
            c.io.memMask(1).poke(false.B)
            c.io.memMask(2).poke(true.B)
            c.io.memMask(3).poke(false.B)

            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(0.U)
            c.io.dataIn(3).poke(1.U)

            c.clock.step(20)

            c.io.dataOut(0).expect(1.U)
            c.io.dataOut(1).expect(0.U)
            c.io.dataOut(2).expect(0.U)
            c.io.dataOut(3).expect(0.U)

        }
    }

}