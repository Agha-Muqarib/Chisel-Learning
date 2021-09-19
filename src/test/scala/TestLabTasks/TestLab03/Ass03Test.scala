package Lab03

import org.scalatest._
import chiseltest._
import chisel3._
  
class Ass03Test extends FreeSpec with ChiselScalatestTester {

    "Ass 03 Test" in {
        
        test(new Ass03){c =>

            c.io.input.poke("b01".U)
            c.clock.step(10)
        }
    }
}


