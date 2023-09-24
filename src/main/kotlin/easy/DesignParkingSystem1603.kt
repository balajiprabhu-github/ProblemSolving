package easy

class ParkingSystem(big: Int, medium: Int, small: Int) {

    var availableBigSlots = big
    var availableMediumSlots = medium
    var availableSmallSlots = small


    fun addCar(carType: Int): Boolean {

        when (carType) {
            1 -> {
                if (availableBigSlots > 0) {
                    availableBigSlots--
                    return true
                }
            }
            2 -> {
                if (availableMediumSlots > 0) {
                    availableMediumSlots--
                    return true
                }
            }
            3 -> {
                if (availableSmallSlots > 0) {
                    availableSmallSlots--
                    return true
                }
            }
        }
        return false
    }

}