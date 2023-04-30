package project.config;


import io.swagger.v3.oas.models.media.*;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;


@SuppressWarnings("unchecked")
@Configuration
class ApiDocsOperationCustomizer implements OperationCustomizer {

    @Override
    public io.swagger.v3.oas.models.Operation customize(io.swagger.v3.oas.models.Operation operation, HandlerMethod handlerMethod) {
        Content content = operation.getResponses().get("200").getContent();
        if (content == null) {
            content = new Content();
            MediaType mediaType = new MediaType();
            mediaType.schema(this.customizeSchema(new Schema<>(), true));
            content.addMediaType("*/*", mediaType);
            operation.getResponses().get("200").content(content);
        } else {
            for(MediaType mediaType : content.values()) {
                mediaType.schema(this.customizeSchema(mediaType.getSchema(), false));
            }
        }

        return operation;
    }

    private Schema<Object> customizeSchema(final Schema<Object> objSchema, boolean isVoid) {
        final Schema<Object> wrapperSchema = new Schema<>();
        wrapperSchema.addProperty("traceId", new StringSchema()._default("5308185e23e44741a71d80a159deb1e3"));
        wrapperSchema.addProperty("code", new IntegerSchema()._default(200));
        wrapperSchema.addProperty("message", new StringSchema()._default("SUCCESS"));
        wrapperSchema.addProperty("dateTime", new DateTimeSchema());
        wrapperSchema.addProperty("data", isVoid ? new StringSchema()._default("null"): objSchema);
        return wrapperSchema;
    }
}
