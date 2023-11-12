import gamble.SplitGamble
import java.util.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val splitGamble = SplitGamble("슈퍼,마리오,루이지")
            splitGamble.roll(2)
        }
    }
}
