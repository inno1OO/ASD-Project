const URL = "http://172.17.144.159:8085/api/v1/auth";
// import axios from "axios";

export async function signUp(state){
    try {
        const result = await fetch(`${URL}/accounts/signup`, 
        {
            method:"POST",
            headers:{
                accept: "application/json",
                "content-type": "application/json"
            },
            body: JSON.stringify(state)
        });
        const obj = await result.json();
        // if (obj.success) {
        //     return obj.data;
        // }
        return obj;
     
    } catch (error) {
        console.log(error);
    }
}


export async function signIn(state){
   
    try {
        const result = await fetch(`${URL}/authenticate`, 
        {
            method:"POST",
            headers:{
                accept: "application/json",
                "content-type": "application/json"
            },
            body: JSON.stringify(state)
        });
        const obj = await result.json();
        // if (obj.success) {
        //     return obj.data;
        // }
        console.log("reponse koneksyon: " + obj);
        return obj;
     
    } catch (error) {
        console.log(error);
    }
}

// export async function signIn(state){
//     axios.post(`${URL}/authenticate`, state)
//       .then(response => {
//         console.log('POST response:', response.data);
//         return response.data;
//       })
//       .catch(error => {
//         console.error('Error sending POST request:', error);
//         throw error;
//       });
// }
