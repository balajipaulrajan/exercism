 // tslint:disable-next-line: no-any
type MayBeArr<T> =  T | any[]
class FlattenArray {
    static flatten<T>(nestedArray: Array<MayBeArr<T>>): T[] {
        return FlattenArray.recursiveFlatten(nestedArray, [])
    }
    static recursiveFlatten<T>(nestedArray: Array<MayBeArr<T>>, accArray: T[]): T[]  {
        if (nestedArray.length === 0) {
             return accArray
        }
        else {
            const [first, ...rest] = nestedArray
            if (Array.isArray(first)) { // if the element is array recursively append to the accumulator.
                return FlattenArray.recursiveFlatten(rest, FlattenArray.recursiveFlatten(first, accArray))
            } else if ( first !== undefined ) {
                return FlattenArray.recursiveFlatten(rest, [...accArray, first])
            } else {
                return FlattenArray.recursiveFlatten(rest, accArray)
            }
        }
    }
}

export default FlattenArray