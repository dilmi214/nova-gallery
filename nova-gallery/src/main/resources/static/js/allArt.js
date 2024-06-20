document.addEventListener("DOMContentLoaded", function() {
    const artList = document.getElementById("artList");

    // fetch and display art
    function fetchArt() {
        fetch('/artPieces/all')
            .then(response => response.json())
            .then(data => {
                artList.innerHTML = '';
                data.forEach(artPiece => {
                    const artDiv = document.createElement('div');
                    artDiv.className = 'art-piece';

                    const title = document.createElement('h2');
                    title.textContent = artPiece.title;

                    const description = document.createElement('p');
                    description.textContent = artPiece.description;

                    const price = document.createElement('p');
                    price.textContent = `Price: $${artPiece.price}`;

                    const artist = document.createElement('p');
                    artist.textContent = `Artist: ${artPiece.artist.name}`;

                    const image = document.createElement('img');
                    image.src = artPiece.imageUrl; // Assuming the backend returns 'imageUrl'
                    image.alt = artPiece.title;
                    image.className = 'art-image';

                    artDiv.appendChild(title);
                    artDiv.appendChild(description);
                    artDiv.appendChild(price);
                    artDiv.appendChild(artist);
                    artDiv.appendChild(image);

                    artList.appendChild(artDiv);
                });
            })
            .catch(error => console.error('Error fetching art pieces:', error));
    }

    // Fetch art on page load
    fetchArt();
});
