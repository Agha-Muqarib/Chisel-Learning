package Lab01

import chisel3._

class Task03(size: Int, maxValue: Int) extends Module {
val io = IO(new Bundle {
val result = Output(Bool())
})

// ' genCounter ' with counter size 'n '

def genCounter(n: Int, max: Int) = {
val count = RegInit(0.U(n.W))

var uMax = max.asUInt 
when ( count === uMax ) {

count := 0.U
} 

.otherwise {
count := count + 1.U
}

count
}

// genCounter instantiation


val counter1 = genCounter(size, maxValue )
io.result := counter1(size -1)


}
