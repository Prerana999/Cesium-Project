# Cesium-Project

**Part 1 - Unit test code review**

After a thorough code review of the two JavaScript files - Cartesian3.js and Cartesian3Spec.js, below are the observations being made:

JavaScript file - Cartesian3.js

- equals(right) {
    console.log(">>>>>>>>>>>>>>Right", right)
    return (
      //this === right ||(not necessary)
      (this.x === right.x && this.y === right.y && this.z === right.z)
    );
  }

According to my observation in the above code, this === right is an unecessary condition and left anf right objects are aleady
compared in the next condition and the testcases run successfully with this condition.

- add(right, result) {
   // if (!(right instanceof Cartesian3)) {
      throw new Error("right is required");
    }

    if (typeof result !== "undefined") {
      result.x = this.x + right.x;
      result.y = this.y + right.y;
      result.z = this.z + right.z;
      return result;
    }

    return new Cartesian3(this.x + right.x, this.y + right.y, this.z + right.z);
  }
       
This condition is again not required as the, typeof operator is returning the type of variable being called.
This is more uselful because it is an easy way to check the type of variable in the code.

Jasmin File - Cartesian3Spec.js

In this we can add more number of testcases for the conditions given in the JavaScript code.
Some of the additional testcases are given below:

//a new test suit added - negative values//

it("add works for nagative values", function () {
    var left = new Cartesian3(-2.0, 3.0, -6.0);
    var right = new Cartesian3(6.0, -5.0, -7.0);
    var result = new Cartesian3();
    var expectedResult = new Cartesian3(4.0, -2.0, -13.0);
    left.add(right, result);
    expect(result).toEqual(expectedResult);
  });

   //new test suite added - rational values//

it("construct with rational values", function(){
    var cartesian = new Cartesian3(-1/3, -2/4, -3/5);
    expect(cartesian.x).toEqual(-1/3);
    expect(cartesian.y).toEqual(-2/4);
    expect(cartesian.z).toEqual(-3/5);
  });

   //new test suite added - negative values//

  it("construct with negative values", function(){
    var cartesian = new Cartesian3(-1, -2, -3);
    expect(cartesian.x).toEqual(-1);
    expect(cartesian.y).toEqual(-2);
    expect(cartesian.z).toEqual(-3);
  });


  //a new test suite added - negative values//

  it("equals returns true for differing negative values", function () {
    var cartesian = new Cartesian3(-1.0, -2.0, -3.0);
    expect(cartesian.equals(new Cartesian3(4, 5, 6))).toEqual(false);
  });
});





