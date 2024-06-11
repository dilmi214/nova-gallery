document.addEventListener('DOMContentLoaded', function() {
    // Fetch artists and populate dropdown menu
    fetch('/artists')
        .then(response => response.json())
        .then(data => {
            const artistDropdown = document.getElementById('artist');
            data.forEach(artist => {
                const option = document.createElement('option');
                option.value = artist.id;
                option.text = artist.name;
                artistDropdown.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching artists:', error));

    // Handle form submission
    document.getElementById('artPieceForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(this);

        fetch('/api/artpieces', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to create art piece');
            }
            return response.json();
        })
        .then(data => {
            console.log('Art piece created successfully:', data);
            // Optionally, you can redirect to another page or show a success message here
        })
        .catch(error => console.error('Error creating art piece:', error));
    });
});
