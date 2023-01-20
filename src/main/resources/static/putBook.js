function putBook() { //완료
    const title=document.getElementById('title').value;
    const author=document.getElementById('author').value;
    const price=document.getElementById('price').value;
    const publisher=document.getElementById('publisher').value;
    console.log(title,author,price,publisher);
    // const form=document.getElementById('form');
    let payload ={
        title:title,
        author:author,
        price:price,
        publisher:publisher
    }
    console.log(payload);
    const url=`http://localhost:8080/book`;
    fetch(url, {
        method: "PUT",
        headers : {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(payload),
    })
        .then((response) => { //응답 결과를 json으로 파싱
            if(response.ok){
                return response.json();
            }
            else{
                throw new Error(`${response.status} 에러가 발생했다`);
            }
        })
        .then((data) => {  //응답 결과로 실행할 동작을 정의
            alert("책이 추가되었습니다.");
            location.reload();
            console.log(data)
        })
        .catch((error) =>{ //오류 발생시
            alert("잘못된 입력입니다.");
            location.reload();
            console.log(error.message);
        })
}
