<%@ include file="components/header.jsp" %>

<div class="row mb-4">
    <div class="col">
        <h1 class="mb-3">Update Tax Filer</h1>
        <p class="lead">Update the information for tax filer ID: ${taxFiler.filerId}</p>
    </div>
</div>

<!-- Update Tax Filer Card -->
<div class="card mb-5">
    <div class="card-header bg-primary text-white">
        <h4 class="mb-0"><i class="fas fa-user-edit me-2"></i>Edit Tax Filer Details</h4>
    </div>
    <div class="card-body">
        <form:form action="${pageContext.request.contextPath}/updateTaxFiler" method="POST" modelAttribute="taxFiler">
            <!-- Hidden field for taxFiler ID -->
            <form:hidden path="filerId" />
            
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="name" class="form-label required-field">Name</label>
                    <form:input path="name" class="form-control" required="true" />
                </div>
                <div class="col-md-6 mb-3">
                    <label for="contact" class="form-label required-field">Contact</label>
                    <form:input path="contact" class="form-control" required="true" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="annualIncome" class="form-label required-field">Annual Income ($)</label>
                    <form:input path="annualIncome" class="form-control currency-input" required="true" type="number" step="0.01" min="0" />
                </div>
                <div class="col-md-4 mb-3">
                    <label for="expenses" class="form-label required-field">Expenses ($)</label>
                    <form:input path="expenses" class="form-control currency-input" required="true" type="number" step="0.01" min="0" />
                </div>
                <div class="col-md-4 mb-3">
                    <label for="taxYear" class="form-label required-field">Tax Year</label>
                    <form:input path="taxYear" class="form-control" required="true" type="number" min="2000" max="2030" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <button type="submit" class="btn btn-primary me-2">
                        <i class="fas fa-save me-2"></i>Update
                    </button>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">
                        <i class="fas fa-arrow-left me-2"></i>Back to List
                    </a>
                </div>
            </div>
        </form:form>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
