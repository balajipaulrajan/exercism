import FlattenArray from './flatten-array'

describe('Flatten Array', () => {
    it('no nesting', () => {
        const expected = [0, 1, 2]
        expect(FlattenArray.flatten([0, 1, 2])).toEqual(expected)
    })

    it('flattens array with just integers present', () => {
        const expected = [1, 2, 3, 4, 5, 6, 7, 8]
        expect(FlattenArray.flatten([1, [2, 3, 4, 5, 6, 7], 8])).toEqual(expected)
    })

    it('5 level nesting', () => {
        const expected = [0, 2, 2, 3, 8, 100, 4, 50, -2]
        expect(FlattenArray.flatten([0, 2, [[2, 3], 8, 100, 4, [[[50]]]], -2])).toEqual(expected)
    })

    it('6 level nesting', () => {
        const expected = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        expect(FlattenArray.flatten([1, [2, [[[[[3]]]]], [4, [[5]]], 6, 7], 8, [[9, [[[[[[[[10]]]]]]]]]]])).toEqual(expected)
    })

    it('6 level nest list with null values', () => {
        const expected = [0, 2, 2, 3, 8, 100, -2]
        expect(FlattenArray.flatten([0, 2, [[2, 3], 8, [[100]], undefined, [[undefined]]], -2])).toEqual(expected)
    })

    it('all values in nested list are null', () => {
       const expected: number[] = []
       expect(FlattenArray.flatten([undefined, [[[undefined]]], undefined, undefined, [[[[undefined]]], undefined, undefined], undefined])).toEqual(expected)
    })

    it('all values in nested list are null', () => {
        const expected = [1, 1, 1 , 1, 1, "balaji"]
        expect(FlattenArray.flatten<number>([1, [[[1]]], 1, 1, 1, [[[[[[["balaji"]]]]]]]])).toEqual(expected)
     })
})
