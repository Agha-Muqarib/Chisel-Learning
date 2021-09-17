package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise05Test extends FreeSpec with ChiselScalatestTester {
"Exercise 05 Test" in {
    
    test(new Exercise05) { c =>
    
    c.io.in0.poke(false.B)
    c.io.in1.poke(true.B)
    c.io.in2.poke(false.B)
    c.io.in3.poke(true.B)        
    c.io.in4.poke(true.B)    
    c.io.in5.poke(false.B)    
    c.io.in6.poke(true.B)    
    c.io.in7.poke(true.B)    


    c.clock.step(10)

    c.io.out.expect(false.B)



    }
}
}