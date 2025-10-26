// // // 1️⃣ Write a function `wait(ms)` that returns a Promise that resolves after `ms` milliseconds.  
// // // Then call it and print `"Done!"` after waiting 1 second.

// // // 2️⃣ Write an `async` function `getPostTitle(id)` that fetches  
// // // `https://jsonplaceholder.typicode.com/posts/{id}` and logs the title.


// //  async function getPosts() {
// //     try{
// //     const res = await fetch("https://jsonplaceholder.typicode.com/posts")
// //     const data  = await res.json();
// //     console.log(data);
// //     }catch(e){
// //         console.error(e);
// //     }
// //  }


// //  getPosts();

// // // 3️⃣ Explain (in your own words): why does this print `1, 3, 2`?


// // // function wait() {
// // //     return new Promise(
// // //         (resolve,reject)=>{
// // //             setTimeout(

// // //                 resolve("done")
// // //             ,1000)
// // //         }
// // //     ).then(result => console.log("hell yeah " + result));
// // // }

// // // wait()


// function getPosts(){
//     return new Promise(
//         (resolve,reject)=>{
//             resolve(fetch("https://jsonplaceholder.typicode.com/posts").json())
//         }
//     )
// }


// getPosts().then(
//     data => console.log(`first param ${data}`),

//     function(data){
//         data => console.log(`second param ${data}`)
        
//     }
// )

// getPosts()