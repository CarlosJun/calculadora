# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: operator.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='operator.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x0eoperator.proto\"\x18\n\x03msg\x12\x11\n\toperators\x18\x01 \x03(\tb\x06proto3')
)
_sym_db.RegisterFileDescriptor(DESCRIPTOR)




_MSG = _descriptor.Descriptor(
  name='msg',
  full_name='msg',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='operators', full_name='msg.operators', index=0,
      number=1, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=18,
  serialized_end=42,
)

DESCRIPTOR.message_types_by_name['msg'] = _MSG

msg = _reflection.GeneratedProtocolMessageType('msg', (_message.Message,), dict(
  DESCRIPTOR = _MSG,
  __module__ = 'operator_pb2'
  # @@protoc_insertion_point(class_scope:msg)
  ))
_sym_db.RegisterMessage(msg)


# @@protoc_insertion_point(module_scope)
