package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Ass02Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 02 Test" in {
    
        test(new Router(UInt(32.W))) { c =>

        // c.io.in.poke(3.U)
        c.io.in.address.poke(4.U)
        c.io.in.data.poke(5.U)
        c.clock.step(10)

        c.io.out.address.expect(4.U)
        c.io.out.data.expect(5.U)

        
        }
    }
}