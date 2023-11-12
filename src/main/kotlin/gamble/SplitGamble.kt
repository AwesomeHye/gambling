package gamble

import kotlin.random.Random

class SplitGamble(rawParticipants: String) {
    private val participants: Array<String>
    private val rooms: Array<String> = arrayOf("(화성)", "(목성)")

    init {
        this.participants = rawParticipants.split(",").map{ it.trim() }.toTypedArray()
        println("총 ${participants.size} 명")
    }

    fun roll(splitCount: Int) {
        participants.shuffle(Random(System.currentTimeMillis()))

        val participantCount = participants.size / splitCount
        var index = 0
        var i = 1
        for (i in 1 until splitCount) {
            val splitParticipants = getSplitParticipants(index, index + participantCount)
            println("${getRoom(i)} $i 조: $splitParticipants, 발표자: ${getMc(splitParticipants)}")
            index += participantCount
        }

        val splitParticipants = getSplitParticipants(index, participants.size)
        println("${getRoom(i+1)} ${i+1} 조: $splitParticipants, 발표자: ${getMc(splitParticipants)}")
    }

    private fun getRoom(i: Int) = rooms[(i - 1) % rooms.size]

    private fun getSplitParticipants(from: Int, to: Int) = participants.slice(from until to)

    private fun getMc(splitParticipants: List<String>) = splitParticipants.random(Random(System.currentTimeMillis()))
}
