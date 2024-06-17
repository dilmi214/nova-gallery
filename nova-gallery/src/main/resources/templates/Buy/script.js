document.addEventListener("DOMContentLoaded", function() {
    // Function to fetch and display all art pieces
    function fetchArtPieces() {
        fetch('/artPieces')
            .then(response => response.json())
            .then(data => {
                const artList = document.getElementById('artList');
                artList.innerHTML = ''; // Clear existing art pieces
                data.forEach(artPiece => { // Correct the variable name
                    const artDiv = document.createElement('div');
                    artDiv.textContent = `Title: ${artPiece.title}, Price: ${artPiece.price}`;
            
                    // Create Buy button
                    const buyButton = document.createElement('button');
                    buyButton.textContent = 'Buy';
                    buyButton.addEventListener('click', function() {
                        // Redirect to the specific page for the art piece
                        window.location.href= `/BuyArtPiece/buyArtPiece.html?id=${artPiece.id}`; 
                        
                    });

                    artDiv.appendChild(buyButton); // Append the Buy button to the artDiv
                    artList.appendChild(artDiv); // Append the artDiv to the artList
                });
            })
            .catch(error => console.error('Error fetching art pieces:', error));
    }

    // Fetch and display art pieces on page load
    fetchArtPieces();
});
