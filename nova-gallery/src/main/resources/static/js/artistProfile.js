document.addEventListener("DOMContentLoaded", function() {
    // Function to get the artist ID from the URL
    function getArtistIdFromURL() {
        const pathArray = window.location.pathname.split('/');
        return pathArray[pathArray.length - 1];
    }

    const artistId = getArtistIdFromURL();

    async function fetchArtistData(artistId) {
        try {
            // Fetch artist details
            const artistResponse = await fetch(`/artists/${artistId}`);
            if (!artistResponse.ok) {
                throw new Error('Failed to fetch artist details');
            }
            const artist = await artistResponse.json();

            // Update the artist name and bio in the HTML
            document.getElementById('artistName').innerText = artist.name;
            document.getElementById('artistBio').innerText = artist.bio;

            // Fetch art pieces by artist ID
            const artPiecesResponse = await fetch(`/artPieces/artist/${artistId}`);
            if (!artPiecesResponse.ok) {
                throw new Error('Failed to fetch art pieces');
            }
            const artPieces = await artPiecesResponse.json();

            // Update the art piece titles in the HTML
            const artPieceList = document.getElementById('artPieceList');
            artPieces.forEach(artPiece => {
                const aTag = document.createElement('a');
                aTag.setAttribute('href', `/artPieces/artPiece/${artPiece.id}`); // Add the artist ID to the URL
                aTag.innerHTML = artPiece.title;
                const listItem = document.createElement('li');
                listItem.appendChild(aTag)
                artPieceList.appendChild(listItem);
            });
        } catch (error) {
            console.error('Error:', error);
        }
    }

    if (artistId) {
        fetchArtistData(artistId);
    }
});
