document.addEventListener("DOMContentLoaded", function() {
    const artList = document.getElementById("artList");

    // fetch and display art
    function fetchArt() {
        fetch('/artPieces/all')
            .then(response => response.json())
            .then(data => {
                artList.innerHTML = '';
                data.forEach(artPiece => {

                    const aArtPieceTag = document.createElement('a');
                    aArtPieceTag.setAttribute('href', `/artPieces/artPiece/${artPiece.id}`); // Add the artist ID to the URL

                    const aArtistTag = document.createElement('a');
                    aArtistTag.setAttribute('href', `/artists/artistProfile/${artPiece.artist.id}`);

                    const artDiv = document.createElement('div');
                    artDiv.className = 'art-piece';

                    const title = document.createElement('h2');
                    title.textContent = artPiece.title;

                    const description = document.createElement('p');
                    description.textContent = artPiece.description;

                    const price = document.createElement('p');
                    price.textContent = `Price: $${artPiece.price}`;

                    const artist = document.createElement('p');

                    const image = document.createElement('img');
                    image.src = artPiece.imageUrl;
                    image.alt = artPiece.title;
                    image.className = 'art-image';

                    aArtPieceTag.innerHTML = artPiece.title;
                    artDiv.appendChild(aArtPieceTag);
                    aArtistTag.innerHTML = artPiece.artist.name;
                    artist.appendChild(aArtistTag);
                    artDiv.appendChild(artist);
                    //artDiv.appendChild(title);
                    artDiv.appendChild(description);
                    artDiv.appendChild(price);
                    artDiv.appendChild(image);

                    artList.appendChild(artDiv);
                });
            })
            .catch(error => console.error('Error fetching art pieces:', error));
    }

    // Fetch art on page load
    fetchArt();
});
