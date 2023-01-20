function getBook(){ //JSON을 html에 값을 정리 필요
    const a=document.getElementById("id").value;
    console.log(a);
    const url=`http://localhost:8080/book/${a}`;
    fetch(url, {
        method: "GET",
        headers : {
            "Content-Type": "application/json",
        },
    })
        .then((response) => {
            if(response.ok){
                return response.json();
            }
            else{
                throw new Error(`${response.status} 에러가 발생했다`);
            }
        })
        .then((data) => {
            document.getElementById("result1").innerHTML=data.data.title;
            document.getElementById("result2").innerHTML=data.data.author;
            document.getElementById("result3").innerHTML=data.data.price;
            document.getElementById("result4").innerHTML=data.data.publisher;
            console.log(data);
        })
        .catch(error => {
            alert("id값 없음");
            console.log(error.message);
            // location.reload();
        });
}