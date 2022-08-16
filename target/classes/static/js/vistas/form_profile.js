window.onload = function () {
    setPreview();
    uploadFileHover();
}

function uploadFileHover() {

    document.getElementById('buttonfile').onclick = function () {
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