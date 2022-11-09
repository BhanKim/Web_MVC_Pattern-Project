/**
 * 
 */
         var googleButton = document.getElementById('google-button');

        // function to get response
        function handleCredentialResponse(response) {
            const responsePayload = decodeJwtResponse(response.credential);
            
            // 이메일값 넘겨주기
    		document.location = "loginApi.do?api_email="+ responsePayload.email;

        }

        window.onload = function () {
            google.accounts.id.initialize({
                // replace your client id below
                client_id: "267053146082-icvrt0ks03smmhl1lkbiqa4c5f7i91q3.apps.googleusercontent.com",
                callback: handleCredentialResponse,
                auto_select: true,
                auto: true
            });
            google.accounts.id.renderButton(
                document.getElementById("google-button"),
                { theme: "filled_blue", size: "large", width: '380' }  // customization attributes
            );
            // also display the One Tap dialog on right side
            // important for auto login
            google.accounts.id.prompt(); 
        }

        // function to decode the response.credential
        function decodeJwtResponse(token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            var jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));
            return JSON.parse(jsonPayload);
        }

        function signOut() {
            google.accounts.id.disableAutoSelect();
            // do anything on logout
            location.reload();
        }