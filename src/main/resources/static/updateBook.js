function updateBook(){ //JSON을 html에 값을 정리 필요
    const u_id=document.getElementById("u_id").value;
    const title=document.getElementById('u_title').value;
    const author=document.getElementById('u_author').value;
    const price=document.getElementById('u_price').value;
    const publisher=document.getElementById('u_publisher').value;
    console.log(title,author,price,publisher);

    const url=`http://localhost:8080/book/${u_id}`;
    let payload ={
        title:title,
        author:author,
        price:price,
        publisher:publisher
    }

    fetch(url, {
        method: "PUT",
        headers : {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(payload),
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
            document.getElementById("result1").innerHTML=data.title;
            document.getElementById("result2").innerHTML=data.author;
            document.getElementById("result3").innerHTML=data.price;
            document.getElementById("result4").innerHTML=data.publisher;
            alert("변경 되었습니다.");
        })
        .catch(error => {
            alert("id값 없거나 잘못된 입력입니다");
            console.log(error.message);
            location.reload();
        });
}