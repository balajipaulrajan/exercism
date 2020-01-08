class Squares {
    private value: number
    constructor(num: number) {
        this.value = num
    }
    get squareOfSum(): number {
        const sum = ( this.value * (this.value + 1)) / 2
        return sum * sum
    }
    get sumOfSquares(): number {
        return ( this.value * (this.value + 1) * (( 2 * this.value) + 1)) / 6
    }
    get difference(): number {
        return this.squareOfSum - this.sumOfSquares
    }
}

export default Squares