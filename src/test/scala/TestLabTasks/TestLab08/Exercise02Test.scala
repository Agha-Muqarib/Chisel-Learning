package Lab08

import org.scalatest._ 
import chisel3._
import chiseltest._

class Exercise02Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 02 Test" in {

        test(new BankedMemory) { c => 

            c.io.write.poke(true.B)
            c.io.writeAddress.poke(6.U)

            c.io.mask(0).poke(false.B) 
            c.io.mask(1).poke(false.B)
            c.io.mask(2).poke(true.B)
            c.io.mask(3).poke(false.B)

            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(0.U)
            c.io.dataIn(3).poke(1.U)
            
            c.clock.step(1)

            c.io.readAddress.poke(6.U)
            c.clock.step(1)
            
        }
    }
}