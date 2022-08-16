window.onload = function () {
    setPreview();
    showFormFragment();
    uploadFileHover();
}


function showFormFragment() {

    document.getElementById("sendverify").onclick = function () {

        document.getElementById("formpart1").style.display = "none";
        document.getElementById("formpart2").style.display = "block";
    }

    document.getElementById("btntoformback").onclick = function () {

        document.getElementById("formpart1").style.display = "block";
        document.getElementById("formpart2").style.display = "none";
    }


    
}

function uploadFileHover() {
   
    document.getElementById('previa').onmouseover = function () {
        document.getElementById('previa').style.cursor = "pointer";
        document.getElementById('card').style.borderColor = "007bff";
    }

    document.getElementById('previa').onmouseleave = function () {
        document.getElementById('card').style.borderColor = "727272";
    }

    document.getElementById('previa').onclick = function () {
        document.getElementById('file').click();
    };
}

function setPreview() {
    // Variables
    const inputFile = document.querySelector('#file');
    const image = document.querySelector('#previa');

    async function encodeFileAsBase64URL(file) {
        return new Promise((resolve) => {
            const reader = new FileReader();
            reader.addEventListener('loadend', () => {
                resolve(reader.result);
            });
            reader.readAsDataURL(file);
        });
    };

    // Eventos
    inputFile.addEventListener('input', async (event) => {
        // Convierto la primera imagen del input en una ruta Base64
        const base64URL = await encodeFileAsBase64URL(inputFile.files[0]);
        // Anyado la ruta Base64 a la imagen
        image.setAttribute('src', base64URL);
    });
}
