<%@ include file="components/header.jsp" %>

<div class="row mb-4">
    <div class="col">
        <h1 class="mb-3">Tax Filers Management</h1>
        <p class="lead">Manage tax filers records in the system.</p>
    </div>
</div>

<!-- Add Tax Filer Card -->
<div class="card mb-5">
    <div class="card-header bg-primary text-white">
        <h4 class="mb-0"><i class="fas fa-plus-circle me-2"></i>Add New Tax Filer</h4>
    </div>
    <div class="card-body">
        <form:form action="${pageContext.request.contextPath}/addTaxFiler" method="POST" modelAttribute="taxFiler">
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
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-save me-2"></i>Save
            </button>
        </form:form>
    </div>
</div>

<!-- Tax Filers List Card -->
<div class="card">
    <div class="card-header bg-dark text-white">
        <h4 class="mb-0"><i class="fas fa-list me-2"></i>Tax Filers List</h4>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contact</th>
                        <th>Annual Income</th>
                        <th>Expenses</th>
                        <th>Taxable Income</th>
                        <th>Tax Year</th>
                        <th class="table-actions">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="taxFiler" items="${taxFilers}">
                        <tr>
                            <td>${taxFiler.filerId}</td>
                            <td>${taxFiler.name}</td>
                            <td>${taxFiler.contact}</td>
                            <td>$<fmt:formatNumber value="${taxFiler.annualIncome}" type="currency" currencySymbol="" pattern="#,##0.00" /></td>
                            <td>$<fmt:formatNumber value="${taxFiler.expenses}" type="currency" currencySymbol="" pattern="#,##0.00" /></td>
                            <td>$<fmt:formatNumber value="${taxFiler.taxableIncome}" type="currency" currencySymbol="" pattern="#,##0.00" /></td>
                            <td>${taxFiler.taxYear}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/showUpdateForm?filerId=${taxFiler.filerId}" 
                                   class="btn btn-sm btn-primary me-1" title="Edit">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/deleteTaxFiler?filerId=${taxFiler.filerId}" 
                                   class="btn btn-sm btn-danger delete-btn" title="Delete">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <!-- No records found message -->
        <c:if test="${empty taxFilers}">
            <div class="alert alert-info">
                <i class="fas fa-info-circle me-2"></i>No tax filers found in the database.
            </div>
        </c:if>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
