document.addEventListener("DOMContentLoaded", function(){
    function getArtPieceIdFromURL() {
        const pathArray = window.location.pathname.split('/');
        return pathArray[pathArray.length - 1];
    }

    const artPieceId = getArtPieceIdFromURL();

     async function fetchArtPieceData(artPieceId) {
            try {

                const artPieceResponse = await fetch(`/artPieces/${artPieceId}`);
                if (!artPieceResponse.ok) {
                    throw new Error('Failed to fetch art details');
                }
                const artPiece = await artPieceResponse.json();

                // Update the artist name and bio in the HTML
                document.getElementById('artPieceTitle').innerText = artPiece.title;
                document.getElementById('artPieceDesc').innerText = artPiece.description;

//                // Fetch art pieces by artist ID
//                const artPiecesResponse = await fetch(`/artPieces/artist/${artistId}`);
//                if (!artPiecesResponse.ok) {
//                    throw new Error('Failed to fetch art pieces');
//                }
//                const artPieces = await artPiecesResponse.json();
//
//                // Update the art piece titles in the HTML
//                const artPieceList = document.getElementById('artPieceList');
//                artPieces.forEach(artPiece => {
//                    const aTag = document.createElement('a');
//                    aTag.setAttribute('href', `/artPieces/artPiece/${artPiece.id}`); // Add the artist ID to the URL
//                    aTag.innerHTML = artPiece.title;
//                    const listItem = document.createElement('li');
//                    listItem.appendChild(aTag)
//                    artPieceList.appendChild(listItem);
//                });
            } catch (error) {
                console.error('Error:', error);
            }
        }

        if (artPieceId) {
            fetchArtPieceData(artPieceId);
        }
});