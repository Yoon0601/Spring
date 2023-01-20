function deleteBook(){ //
    const a=document.getElementById("id2").value;
    console.log(a);
    const url=`http://localhost:8080/book/${a}`;
    fetch(url, {
        method: "DELETE",
        headers : {
            "Content-Type": "application/json",
        },
    })
        .then((response) => {
            if(response.ok){
               response.json();
            }
            else{
                throw new Error(`${response.status} 에러가 발생했다`);
            }
        })
        .then((data) => {
            alert("책 정보가 삭제되었습니다.");
            console.log(data);
            location.reload();
        })
        .catch(error => {
            alert("id값 없음");
            console.log(error.message);
            location.reload();
        });
}

