const url = 'http://localhost:8080/RoastBean_WebProject/';
//위에 링크는 공유하고 싶은 링크입니다. 수정해야함
function kakaoShare(){//공유 하기위한 js입니다.
  var resultImg = document.querySelector('#resultImg');
  var resultAlt = resultImg.firstElementChild.alt;
  const shareTitle = '나와 어울리는 커피 결과';
  const shareDes = infoList[resultAlt].name;
  const shareImage = url + 'img/image' + resultAlt + '.png';//공유하고 싶은 이미지
  const shareURL = url + 'page/result' + resultAlt + '.jsp';//shareURL로 이동시키겠다.
//http://localhost:8080/RoastBean_WebProject/img/image0.png
  Kakao.Link.sendDefault({
    objectType: 'feed',
    content: {
      title: shareTitle,
      description: shareDes,
      imageUrl: shareImage,
      link: {
        mobileWebUrl: shareURL,
        webUrl: shareURL
      },
    },

    buttons: [
      {
        title: '결과확인하기',
        link: {
          mobileWebUrl: shareURL,
          webUrl: shareURL,
        },
      },
    ]
  });
}
