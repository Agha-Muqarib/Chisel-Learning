package Lab07

import chisel3._
import org.scalatest._ 
import chiseltest._

class Exercise01Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 01 Test" in {

        test( new Exercise01 ) { c => 
        
        c.io.input1.bits.poke(1.U)
        c.io.input2.bits.poke(2.U)
        c.io.input1.valid.poke(1.B)
        c.io.input2.valid.poke(1.B)
        c.io.consumer.ready.poke(1.B)

        c.clock.step(20)


        }
    }
}