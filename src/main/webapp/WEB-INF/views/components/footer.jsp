    </div>
    
    <footer class="bg-dark text-light py-3 mt-5">
        <div class="container text-center">
            <p class="mb-0">&copy; 2025 Tax Filing System. All rights reserved.</p>
        </div>
    </footer>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- jQuery for additional functionality -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <script>
        // Confirmation for delete actions
        $('.delete-btn').on('click', function(e) {
            if (!confirm('Are you sure you want to delete this tax filer?')) {
                e.preventDefault();
            }
        });
        
        // Format currency inputs
        $('.currency-input').on('input', function() {
            let value = $(this).val().replace(/[^\d.]/g, '');
            if (value) {
                let numValue = parseFloat(value);
                if (!isNaN(numValue)) {
                    $(this).val(numValue.toFixed(2));
                }
            }
        });
    </script>
</body>
</html>
