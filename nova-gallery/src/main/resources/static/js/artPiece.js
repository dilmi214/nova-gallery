document.addEventListener("DOMContentLoaded", function() {
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

            // Create the artist hyperlink
            const aArtistTag = document.createElement('a');
            aArtistTag.setAttribute('href', `/artists/artistProfile/${artPiece.artist.id}`);
            aArtistTag.innerText = artPiece.artist.name;

            // Update the art piece details in the HTML
            document.getElementById('artPieceTitle').innerText = artPiece.title;
            document.getElementById('artPieceDesc').innerText = artPiece.description;
            document.getElementById('artPiecePrice').innerText = `Price: $${artPiece.price}`;

            // Clear and append the artist hyperlink to the artist element
            const artistElement = document.getElementById('artPieceArtist');
            artistElement.innerHTML = 'Artist: ';
            artistElement.appendChild(aArtistTag);

            document.getElementById('artPieceImage').src = artPiece.imageUrl;
        } catch (error) {
            console.error('Error:', error);
        }
    }

    if (artPieceId) {
        fetchArtPieceData(artPieceId);
    }
});
